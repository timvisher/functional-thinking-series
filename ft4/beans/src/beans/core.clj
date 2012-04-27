(ns beans.core)

(defn address [name streets city state zip]
  {:name name
   :streets streets
   :city city
   :state state
   :zip zip})
