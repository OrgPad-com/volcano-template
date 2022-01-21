(ns {{name}}.build
  (:require [volcano.build :as build]
            [{{name}}.config :as config]))

(defn -main [& args]
  (build/build-web! (config/config)))
