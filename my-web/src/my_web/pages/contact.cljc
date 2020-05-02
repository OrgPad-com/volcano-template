(ns my-web.pages.contact
  (:require [my-web.routes :as routes]
            [bidi.bidi :as b]))

(defn hiccup []
  (list
    [:h1 "Contact"]
    [:p "I don't have any contact yet, but you can add it here. "
     [:a {:href (b/path-for routes/routes :page/index)} "Go back to index"] "."]))
