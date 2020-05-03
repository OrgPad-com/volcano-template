(defproject {{name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.742"]
                 [thheller/shadow-cljs "{{shadow-cljs-version}}"]
                 [bidi "{{bidi-version}}"]
                 [binaryage/devtools "{{devtools-version}}"]
                 [reagent "{{reagent-version}}"]
                 [venantius/accountant "{{accountant-version}}"]{{#garden?}}
                 [garden "{{garden-version}}"]{{/garden?}}
                 [orgpad/volcano "{{volcano-version}}"]]

  :plugins [{{#garden?}}[lein-garden "{{lein-garden-version}}"]{{/garden?}}{{#less?}}
            [lein-less "1.7.5"]{{/less?}}]

  :main {{name}}.build

  :source-paths ["src"]

{{#garden?}}

  :garden {:builds [{:id           "{{name}}"
                     :source-paths ["src"]
                     :stylesheet   {{name}}.css.core/styles
                     :compiler     {:output-to     "resources/css/{{name}}.css"
                                    :pretty-print? true}}]}
{{/garden?}}{{#less?}}
  :less {:source-paths ["less"]
         :target-path  "resources/css"}
{{/less?}}

  :clean-targets ^{:protect false} ["resources/js" "target" {{#garden?}}"resources/css"{{/garden?}}{{#less?}}"resources/css"{{/less?}}]

{{#garden?}}  :profiles {:dev {:prep-tasks [["garden" "once"]]}}
{{/garden?}}{{#less?}}  :profiles {:dev {:prep-tasks [["less" "once"]]}}{{/less?}})
