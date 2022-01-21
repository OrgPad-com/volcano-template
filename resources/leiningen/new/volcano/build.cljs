(ns {{name}}.build
  (:require [volcano.build :as build]
            [{{name}}.config :as config]))

(defn build []
  (build/build-web! (config/config)))
