(ns my-web.dev
  (:require [volcano.dev :as volcano]
            [reagent.dom :as r-dom]
            [my-web.config :as config]))

(defn mount-root
  "Rendering of the current page inside :div#app element."
  []
  (r-dom/render [volcano/render (config/config)]
                (.getElementById js/document "app")))

(defn init
  "Init function of the dev."
  []
  (volcano/set-routing! (config/config))
  (mount-root))
