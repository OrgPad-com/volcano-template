(ns leiningen.new.volcano
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "volcano"))

(defn volcano
  "Static web generated with Volcano."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' volcano project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
