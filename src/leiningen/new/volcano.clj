(ns leiningen.new.volcano
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.set :as set]))

(defn- css-generator
  "Returns either :none, :less or :garden. When options are incorrect, it halt the generation."
  [options]
  (let [options-set (into #{} options)
        all-options #{"+less" "+garden"}]
    (cond (not (set/subset? options-set all-options)) (main/abort "\nError: only profiles +less and +garden are valid.")
          (= options-set all-options) (main/abort "\nError: choose either +less, or +garden.")
          (options-set "+less") :less
          (options-set "+garden") :garden
          :else :none)))

(def render (renderer "volcano"))

(defn volcano
  "Static web generated with Volcano."
  [name & options]
  (let [css (css-generator options)
        data {:name                       name
              :sanitized                  (name-to-path name)
              :less?                      (= css :less)
              :garden?                    (= css :garden)
              :css?                       (= css :none)
              :volcano-version            "0.1.0"
              :reagent-version            "0.10.0"
              :bidi-version               "2.1.6"
              :accountant-version         "0.2.5"
              :devtools-version           "0.9.10"
              :shadow-cljs-version        "2.8.109"
              :react-version              "^16.13.1"
              :react-dom-version          "^16.13.1"
              :create-react-class-version "^15.6.3"
              :garden-version             "1.3.9"
              :lein-garden-version        "0.3.0"
              :lein-less-version          "1.7.5"}]
    (main/info "Generating fresh 'lein new' Volcano project.")
    (->files data
             ["src/{{sanitized}}/dev.cljs" (render "dev.cljs" data)]
             ["src/{{sanitized}}/build.clj" (render "build.clj" data)]
             ["src/{{sanitized}}/config.cljc" (render "config.cljc" data)]
             ["src/{{sanitized}}/routes.cljc" (render "routes.cljc" data)]
             ["src/{{sanitized}}/pages/contact.cljc" (render "pages/contact.cljc" data)]
             ["src/{{sanitized}}/pages/index.cljc" (render "pages/index.cljc" data)]
             (case css
               :garden ["src/{{sanitized}}/css/core.clj" (render "css/core.clj" data)]
               :less ["less/{{name}}.less" (render "default.less" data)]
               :none ["resources/css/{{name}}.css" (render "default.css" data)])
             ["resources/index.html" (render "resources/index.html" data)]
             [".gitignore" (render ".gitignore" data)]
             ["package.json" (render "package.json" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)])))
