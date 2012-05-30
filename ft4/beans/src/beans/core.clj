(ns beans.core)

(defn address [name streets city state zip]
  {:name name
   :streets streets
   :city city
   :state state
   :zip zip})

(defn named-address [& {:keys [name streets city state zip]}]
  (address name streets city state zip))

(defrecord Address [name streets city state zip])
