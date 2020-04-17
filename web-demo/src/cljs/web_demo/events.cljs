(ns web-demo.events
  (:require
   [re-frame.core :as re-frame]
   [web-demo.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
  :click-increment
  (fn [db _]
    (update-in db [:click-counter] (fnil inc 0) )))


