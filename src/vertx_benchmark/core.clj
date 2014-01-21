(ns vertx-benchmark.core
  (:require [vertx.http :as http]
            [vertx.embed :as embed]))

(def response "foo";(slurp "../index.html")
  )

(defn -main [& args]
  (embed/set-vertx! (embed/vertx))
  (-> (http/server)
    (http/on-request #(-> (http/server-response %)
                        (http/end response)))
    (http/listen 8080))
  (read) ;prevents exit
  )
