(defproject {{name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.742"]
                 [thheller/shadow-cljs "{{shadow-cljs-version}}"]
                 [bidi "{{bidi-version}}"]
                 [binaryage/devtools "{{devtools-version}}"]
                 [reagent "{{reagent-version}}"]
                 [venantius/accountant "{{accountant-version}}"]
                 [orgpad/volcano "{{volcano-version}}"]]
  :main {{name}}.build
  :source-paths ["src"]
  :clean-targets ^{:protect false} ["resources/js" "target"])
