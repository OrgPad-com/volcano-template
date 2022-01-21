(ns {{name}}.dev
  (:require [volcano.dev :as volcano]
            [{{name}}.config :as config]))

(defn mount-root
  "Rendering of the current page inside :div#app element."
  []
  (volcano/mount-root! (config/config)))

(defn init
  "Init function of the dev."
  []
  (volcano/init! (config/config)))