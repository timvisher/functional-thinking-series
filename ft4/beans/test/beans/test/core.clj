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
