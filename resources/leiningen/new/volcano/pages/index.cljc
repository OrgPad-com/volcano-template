(ns {{name}}.pages.index
  (:require [{{name}}.routes :as routes]
            [bidi.bidi :as b]))

(defn hiccup []
  (list
    [:h1 "Index page"]
    [:p "This is an index page and its content is up to you! Also visit "
     [:a {:href (b/path-for routes/routes :page/contact)} "contact page"] "."]
    [:p {:style {:color            "navy"
                 :background-color "lightblue"
                 :padding          5}}
     "You can use any hiccup you want:"]
    [:ul (for [index (range 10)]
           [:li "The element " (inc index)])]))
