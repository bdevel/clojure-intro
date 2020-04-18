(ns basics.intro)

;; Guide here: https://clojure.org/guides/learn/syntax

;; Forms
;;==========================================

;; Basics
nil
true
false
1
2.0
1/5  ;; fractions
22/7
"my string"
"yes \"air quotes\" are cool"
:foo-bar
:foo_bar
:$foo?
::foo  ;; namespaced keywords

;; symbol
'example

;; vectors
[1 2 3]
["a" "vector" "of strings"]

; set of unique values
#{1 2 3}

;; maps
{:a 1 :b 2}

{"plus" +
 "a-vector" [:a :b]}

;; lists O(n)
'(1 2 3 :four "five")

;; regex
#"\d+"

;; charecter
\x

;; Operations
;;==========================================

;; C style function call
;; function(arg1, arg2)

;; Lisp function call
;; (function arg1 arg2)

;; Lists are read/evaluated from beginning to end, inside first.
;; Lisp is an acronym for List Processing
(+ 1 2 3) ;; 1 + 2 + 3
(* 2 3 4) ;; 2 * 3 * 4
(/ 100 2 10)

(max 0 1 2 3 4)
(min 0 1 2 3 4)
(max [0 1 2 3 4])
(apply max [0 1 2 3 4])

;; Nested forms
(* 2 (+ 1 2))
(/ (+ 3 4 5) 6)
(/ (+ 1 2 (* 3 4)) 5.0)


;; Definitions
(def first-name "Bob")
(def age (- 2020 1990))

;; Strings and printing
(str "My name is " first-name ".")
(str "My name is " nil ".")
(println "What is this:" (+ 1 2))


;; Basics
;;==========================================

;; Flow control
(if true "yes" "no")
(if nil "yes" "no")

(if 0 "yes" "no")
(if-not (nil? "") "yes" "no")

(or nil 1)
(or nil false :maybe true)

(or (= 0 1)
    (= "yes" "no"))

(and :maybe "yes" false)

(= 0 nil)
(= "" nil)

(if (or (> age 21)
        (< age 100))
  "Buy me beer"
  "Buy me water")

;; if can only take 3 forms, use `do` when you need more
(if (and (> age 21)
         (not= name "Sam"))
  (do (println "Buy me beer")
      (println "Get hang over"))
  (println "Buy me water"))

;; When runs all the forms if condition is true. Also when-not
(when (> age 21)
  (println "Drink beer")
  (println "Get hang over"))



;; Data structures
;;==========================================

;; vectors
(vector :a :b :c)
(nth [0 1 2 3] 3)


;; different ways to add items to list/vector. Note the return value type.
(conj [0 1] 2) ;; conjoin
(cons 2 [0 1])
(into [0 1] '(3 4))
(concat [0 1] [3 4])

;; useful list/vector functions
(sort [4 5 2 9 0 3])

(first [0 1 2])
(last [0 1 2])
(next [0 1 2])
(rest [0 1 2])
(next []) ;; nil
(rest []) ;; empty list
(butlast [0 1 2])
(take 2 [0 1 2 3 4])
(drop 2 [0 1 2 3 4])
(drop-while neg? [-1 -2 -6 -7 1 2 3 4 -5 -6 0 1])
(take-while neg? [-2 -1 0 1 2 -3 4])

(filter even? [0 1 2 3 4 5 6])
(remove even? (range 1 10))

(some neg? [-2 -1 0 1 2 3])
(some #(= 5 %) [0 1 2 3 4 5])

(map inc [0 1 2])
(reduce + [0 1 2 3])

;; Maps - O(1)
(hash-map :name "Bob" :age 42)

(keys {:name "Bob" :age 42})
(vals {:name "Bob" :age 42})

;; accessing values
(get {:name "Bob" :age 42} :name)
(:name {:name "Bob" :age 42})

(def user {:id 123
           :name "Bob"
           :age 21
           :address {:street "123 Fake"
                     :city "Seattle"}})

(get-in user [:address :city])

(assoc {} :id 123)
(assoc-in {} [:address :bar] 123)
(assoc-in user [:address :state] "WA")
;; user[:address][:state][:asdf]

(def user-db {123 {:name    "Bob"
                   :age     21
                   :address {:street "123 Fake"
                             :city   "Seattle"}}
              456 {:name    "Tom"
                   :age     21
                   :address {:street "123 Fake"
                             :city   "Seattle"}}})

;; Can build the path programatically
(update-in user-db [(:id user) :age] inc)


;; Threads
;; Successively takes result and puts it in first argument of next form
;; same as (- (/ (+ 10 2) 2) 1)
(- (/ (+ 10 2) 2) 1)
;; ((10 + 2) / 2) - 1

(-> 10
  (/ 2)
  (- 1))

(-> {:age 10}
  (update :age inc)
  (assoc :name "Bob")
  (update :name str " Johnson"))

;; Successively takes result and puts it as last argument of next form
(->> (range 100)
     (filter even?)
     (take 10)
     (reduce +))

;; conditionally thread
(def user2 {:age 5})
(cond-> user2
  (< (:age user2) 10)
  (assoc :is-young true)
  
  (> (:age user2) 100)
  (assoc :is-old true))

;; Functions
;;==========================================

"It's better to have 100 functions operate on 1 data structure
than to have 10 fuctions operate on 10 data structures."
;; Alan Parlis

(def human-age 21)

;; not docs
(defn dog-years
  "Converts human age to dog age."
  [human-yrs]
  (/ human-yrs 7.0))

(dog-years human-age)
(println "Age " human-age
         " In dog years is "
         (dog-years age))


;;variadic functions
(defn bag-it
  "Adds items to a hashmap"
  [bag & items]
  {bag items})

(bag-it :veggies "carrots" "cucumber" "celery")

;; Anonymous functions

(fn [x] (+ 6 x))

;; Equivalent to: (fn [x] (+ 6 x))
#(+ 6 %)

;; Equivalent to: (fn [x y] (+ x y))
#(+ %1 %2)

;; Equivalent to: (fn [x y & zs] (println x y zs))
#(println %1 %2 %&)

;; Using anonymous functions
;; can call fuctions like so
(#(+ 2 %) 3)

((fn [v] (+ v 2)) 3)

(map inc [0 1 2])
(map #(+ 2 %) [0 1 2])

(def inc2
  (fn [v] (+ v 2)))

(map inc2 [0 1 2 3])

;; can make a function return a fuction
(defn inc-maker
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 3)
(map inc3 [0 1 2 3])


;; function can come from logic
((if (> (rand) 0.5) + -)
  1 2)

;; Multi-Methods
;; https://clojure.org/reference/multimethods

;; Provide a name and dispatch function, optionally default if no defmethod is defined
(defmulti label #(:type %))

(defmethod label :default
  [m]
  (str "OTHER: " (:name m)))

(defmethod label "admin"
  [m]
  (str "ADMIN: " (:name m)))

(defmethod label "super"
  [m]
  (str "SUPER: " (:name m)))

(cond false
      1
      false
      2
      true
      3
      true
      4)
  
(label {:type "admin" :name "Bob"})
(label {:type "super" :name "Sam"})
(label {:type "unknown" :name "Froggy"})



;; let and loops
;;=====================================

(def x 0)
(let [x 1] x)
x

(let [age 21
      dog-age (dog-years age)
      address "123 Fake St"
      address (str address " Seattle, WA")]
  {:age age
   :dog-age dog-age
  	:address address})

;; destructuring
(let [[a b & others] [0 1 2 3 4]
      {:keys [age name]} {:age 21 :name "Bob"}]
  [a b age name])

(def names ["Bob" "Tom" "Sam" "Pam"])

(run! println names)
(run! #(println "Name: " %) names)

(println "hello")
(reduce
  (fn [out name]
    (str out "\n  " name))
  names)

(let [output (reduce
               (fn [out name]
                 (-> out
                     (update :names conj name)
                     (update :all str name " == ")))
               {:names ["existing"]
                :all   ""}
               ["bob" "sam" 3]) ]
  (get output :names))

(loop [items ["Bob" "Tom" "Sam" "Pam"]
       out ""]
  (if items
     (recur (next items)
            (str out (first items) " --> "))
     out))


(loop [items names
       out ""]
  (if (empty? items)
     out
     (recur (rest items)
            (str out "\n  " (first items)))))

;; State
;; ==========================================

(def app-state (atom {:success 0 :errors 0}))

(defn make-dough []
  (println "Making dough.")
  (swap! app-state update :success inc))

(defn reboot []
  (reset! app-state {:success 0 :errors 0}))

(comment
  (make-dough)
  (deref app-state)
  (:success @app-state)
  (reboot)
  (:success @app-state)
  )


;; Macros
;; ===============================
;; Source -> Reader -> Evaluator
;; "Homoiconic" "the same" "representation"
;; "code as data"

(defmacro backwards [form]
  (reverse form))

(backwards (" backwards" " am" "I" str))


(defn unless
  ""
  [cond & forms]
  (when cond
    (println "Forms: " forms)))

(unless true (println "Running!"))


(defmacro unless [cnd & forms]
  `(when (not ~cnd) ~@forms))

(unless (= 1 2)
  (println "YES!")
  (println "YES AGAIN!"))

(when (not true)
  (println "YES!")
  (println "YES AGAIN!"))


(when (= 1 1)
  (println "hello")
  (println "world"))

(if (= 1 1)
  (do (println "hello")
      (println "world")))


;; Mutli-threading
;; =================================
(def f (future (Thread/sleep 5000)
               (println "done")
               100))
@f

;; promise
(def p (promise))
(future
  (Thread/sleep 5000)
  (deliver p 123))

(realized? p)
(deref p)

;; pmap for parallel workers
;; A function that simulates a long-running process by calling Thread/sleep:
(defn long-running-job [n]
    (Thread/sleep 2000) ; wait for 2 seconds
    (+ n 10))

;; Use `doall` to eagerly evaluate `map`, which evaluates lazily by default.

;; With `map`, the total elapsed time is just under 4 * 2 seconds:
(time (doall (map long-running-job (range 4))))
"Elapsed time: 8008.13412 msecs"
;; (10 11 12 13)

;; With `pmap`, the total elapsed time is just over 3 seconds:
(time (doall (pmap long-running-job (range 4))))
"Elapsed time: 2005.687785 msecs"
;; (10 11 12 13)



;; Java Interop, dop operator
;; ===========================

(import 'javax.swing.JFrame
        'javax.swing.JPanel
        'javax.swing.JButton)

;; In Java
;; JFrame frame = new JFrame("Hello Frame")
;; frame.setSize(200, 200)
;; frame.setVisibility(true)

(def frame (JFrame. "Hello Frame"))
(.setSize frame 200 200)
(.setVisible frame true)

(def panel (JPanel.))
(.setContentPane frame panel)

(def button (JButton. "Click Me!"))
(.add panel button)
(.revalidate button)



