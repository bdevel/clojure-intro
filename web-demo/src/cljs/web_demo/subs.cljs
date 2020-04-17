(ns web-demo.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
  :name
  (fn [db]
    (:name db)))

(re-frame/reg-sub
  :click-counter
  (fn [db]
    (get-in db [:click-counter])))
