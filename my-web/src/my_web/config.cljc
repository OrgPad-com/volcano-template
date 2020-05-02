(ns my-web.config
  (:require [my-web.routes :as routes]
            [my-web.pages.index :as index]
            [my-web.pages.contact :as contact]))

(defn config []
  {:resource-dir     "resources"
   :target-dir       "build"
   :pages            {:page/index   {:hiccups (index/hiccup)}
                      :page/contact {:hiccups (contact/hiccup)}}
   :routes           routes/routes
   :default-route    :page/index
   :default-template [:html
                      [:head
                       [:title "my-web"]
                       [:meta {:charset "utf-8"}]]
                      [:body :volcano/hiccups]]
   :exclude-files    #{"index.html"}
   :exclude-dirs     #{"js"}})
