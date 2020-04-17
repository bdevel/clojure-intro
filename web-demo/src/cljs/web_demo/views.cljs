(ns web-demo.views
  (:require
   [re-frame.core :as re-frame]
   [web-demo.subs :as subs]
   ))

(defn click-button []
  [:button
    {:on-click (fn [e]
                 (re-frame/dispatch [:click-increment]))}
    "Click Me!"])

(defn get-val
  ""
  [& path]
  (deref (re-frame/subscribe (into [] path))))


(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        ]
    [:div
     [:h1 "Hello from " @name "!"]
     [:p "This is the greatest demo of all time."]
     [:input {:type "text"}]
     (click-button )
     ;;[:p "Clicks == " @(re-frame/subscribe [:click-counter]) ]
     [:p "Clicks == " (get-val :click-counter) ]
     ]))
