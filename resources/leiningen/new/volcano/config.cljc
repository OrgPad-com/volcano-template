(ns {{name}}.config
  (:require [{{name}}.routes :as routes]
            [{{name}}.pages.index :as index]
            [{{name}}.pages.contact :as contact]))

(defn config []
  {:resource-dir     "resources"
   :target-dir       "build"
   :pages            {:page/index   {:hiccups (index/hiccup)}
                      :page/contact {:hiccups (contact/hiccup)}}
   :routes           routes/routes
   :default-route    :page/index
   :default-template [:html
                      [:head
                       [:title "{{name}}"]
                       [:meta {:charset "utf-8"}]]
                      [:body :volcano/hiccups]]
   :exclude-files    #{"index.html"}
   :exclude-dirs     #{"js"}})