(ns leiningen.new.volcano
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "volcano"))

(defn volcano
  "Static web generated with Volcano."
  [name]
  (let [data {:name                       name
              :sanitized                  (name-to-path name)
              :volcano-version            "0.1.0-SNAPSHOT"
              :reagent-version            "0.10.0"
              :bidi-version               "2.1.6"
              :accountant-version         "0.2.5"
              :devtools-version           "0.9.10"
              :shadow-cljs-version        "2.8.109"
              :react-version              "^16.13.1"
              :react-dom-version          "^16.13.1"
              :create-react-class-version "^15.6.3"}]
    (main/info "Generating fresh 'lein new' Volcano project.")
    (->files data
             ["src/{{sanitized}}/dev.cljs" (render "dev.cljs" data)]
             ["src/{{sanitized}}/build.clj" (render "build.clj" data)]
             ["src/{{sanitized}}/config.cljc" (render "config.cljc" data)]
             ["src/{{sanitized}}/routes.cljc" (render "routes.cljc" data)]
             ["src/{{sanitized}}/pages/contact.cljc" (render "pages/contact.cljc" data)]
             ["src/{{sanitized}}/pages/index.cljc" (render "pages/index.cljc" data)]
             ["resources/index.html" (render "resources/index.html" data)]
             [".gitignore" (render ".gitignore" data)]
             ["package.json" (render "package.json" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)])))
