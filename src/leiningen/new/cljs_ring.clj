(ns leiningen.new.cljs-ring
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "cljs-ring"))

(defn cljs-ring
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' cljs-ring project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render ".gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["resources/cljs/{{sanitized}}/connect.cljs" (render "resources/cljs/tesselax/connect.cljs" data)]
             ["resources/cljs/{{sanitized}}/core.cljs" (render "resources/cljs/tesselax/core.cljs" data)]
             ["resources/public/index.html" (render "resources/public/index.html" data)]
             ["doc/intro.md" (render "doc/intro.md" data)]
             ["src/{{sanitized}}/core.clj" (render "src/tesselax/core.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "test/tesselax/core_test.clj" data)])))
