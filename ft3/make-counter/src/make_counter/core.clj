(ns make-counter.core)

(defn make-counter []
  (let [incremented (atom 0)]
    (fn [] (swap! incremented inc))))

(def c1 (make-counter))

(c1)
(c1)
(c1)

(def c2 (make-counter))
(prn (str "C1 = " (c1) ", C2 = " (c2)))  ; "C1 = 4, C2 = 1"