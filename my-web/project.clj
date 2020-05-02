(defproject my-web "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.742"]
                 [thheller/shadow-cljs "2.8.109"]
                 [bidi "2.1.6"]
                 [binaryage/devtools "0.9.10"]
                 [reagent "0.10.0"]
                 [venantius/accountant "0.2.5"]
                 [garden "1.3.9"]
                 [orgpad/volcano "0.1.0-SNAPSHOT"]]

  :plugins [[lein-garden "0.3.0"]]

  :main my-web.build

  :source-paths ["src"]


  :garden {:builds [{:id           "my-web"
                     :source-paths ["src"]
                     :stylesheet   my-web.css.core/styles
                     :compiler     {:output-to     "resources/css/my-web.css"
                                    :pretty-print? true}}]}

  :clean-targets ^{:protect false} ["resources/js" "target"])
