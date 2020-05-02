(ns my-web.build
  (:require [volcano.build :as build]
            [my-web.config :as config]))

(defn -main [& args]
  (build/build-web! (config/config)))
