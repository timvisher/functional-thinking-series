(ns beans.test.core
  (:use [beans.core])
  (:use [clojure.test]))

(defn test-address []
  (address "foo" ["data way" "driven ct" "development cr"] "Clojure" "Functional Programming" "12345"))

(deftest it-should-allow-me-to-lookup-field-values
  (is (= "foo" (:name (test-address)))))

(deftest it-should-allow-me-to-derive-a-new-value
  (is (= "bar" (:name (assoc (test-address) :name "bar")))))

(def can_t-mutate-me (test-address))

(deftest it-should-not-allow-me-to-mutate-it_s-state
  (try
    (do
      (set! can_t-mutate-me (assoc can_t-mutate-me :name "bar"))
      (is nil "Whoops! Should've thrown an exception!"))
    (catch IllegalStateException e)))

(deftest it-should-be-a-basic-map
  (is (instance? java.util.Map (test-address))))

(deftest it-should-be-a-basic-map
  (is (instance? java.util.Map (->Address "foo" ["bar"] "bat" "bin" "biz"))))

(deftest it-should-be-a-Address-type-that-we-defined
  (is (instance? beans.core.Address (->Address "foo" ["bar"] "bat" "bin" "biz"))))

(deftest it-should-allow-uac-field-lookup
  (is (= "foo" (:name (->Address "foo" ["bar"] "bat" "bin" "biz"))))
  (is (= "foo" (:name (test-address)))))

(defmacro xtime [expr]
  `(let [start# (. System (nanoTime))
         ret# ~expr]
     (- (. System (nanoTime)) start#)))

(deftest it-should-perform-better-at-field-lookup
  (let [address-record (->Address "foo" ["bar"] "bat" "bin" "biz")
        address-map (test-address)]
    (is (< (xtime (dotimes [n 10000000] (:name address-record))) (xtime (dotimes [n 10000000] (:name address-map)))))))

(deftest it-should-perform-better-at-field-lookup-but-it-does-not
  (let [address-record (map->Address (test-address))
        address-map (test-address)]
    (is (not (< (xtime (:name address-record)) (xtime (:name address-map)))))))