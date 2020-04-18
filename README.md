

# Intro To Clojure

### Setup
To play with ClojureScript without installing anything use the [online REPL](https://clojurescript.io/).

Install [OpenJDK](https://github.com/AdoptOpenJDK/homebrew-openjdk) `brew cask install adoptopenjdk`

Install a Clojure build tool, [Leiningen](https://leiningen.org/) with `brew install leiningen` for mac. Then start a
new project with:

``` sh
lein new app my-demo
cd my-demo
lein run # runs the app
lein repl # start repl
```

Alternatively, install [Clojure
tooling](https://clojure.org/guides/getting_started) with 
`brew install clojure/tools/clojure`
and follow [guide simple apps](https://clojure.org/guides/deps_and_cli)

Best and easiest editor to use is [VSCode with Calva](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva)

### Start Learning
* Start with the [intro.clj language demonstration](basics/src/basics/intro.clj)
* Then check out the  [web demo with Re-Frame](web-demo/)

## LISP History
John McCarthy developed Lisp in 1958 and is the second-oldest high-level programming
language in widespread use today. Only Fortran is older, by one year.
Lisp has changed since its early days, and many dialects have existed over its
history. Today, the best-known general-purpose Lisp dialects are Clojure, Common
Lisp, Scheme, and emacs lisp (elisp).

Lisp was originally created as a practical mathematical notation for computer
programs, influenced by the notation of lambda calculus. It quickly became the
favored programming language for artificial intelligence (AI) research. 

Lisp programs can manipulate source code as a data structure, giving rise to the
macro systems that allow programmers to create new syntax or new domain-specific
languages embedded in Lisp.

Program code is written as s-expressions, or
parenthesized lists.  For instance, a function f that takes three arguments
would be called as `(f arg1 arg2 arg3)`

[Reference, Wikipedia](https://en.wikipedia.org/wiki/Lisp_(programming_language))

## Why Clojure

Clojure designed by	Rich Hickey in 2007. Clojure is a functional language with a dynamic emphasis.

* All data structures immutable & persistent, supporting recursion.
* Not OS dependent, runs on many virtual machines (JVM, NodeJS, CLR, Erlang,
  Graal). "Hosted language"
* Bytecode + JIT compilation on JVM/AdoptOpenJDK
* Designed for Concurrency, [Read about state](https://clojure.org/about/state). Immutability makes much of the problem go away.
* OOP overrated, adds incidental complexity (aka, "complecting") and not
  focusing on business logic. Mutable stateful objects are the new spaghetti
  code - concurrency nightmare.
* OOP has imperative programming baked into it. There is no way to observe a
  stable state (even to copy it) without blocking others from changing
  it. OOP understands the true notion of a value, say, 42, as something that
  would never change, but usually don’t extend that notion of value to their
  object’s state.
* In Clojure’s model, value calculation is purely functional. Values never change.
* "It is better to have 100 functions operate on one data structure than to have
  10 functions operate on 10 data structures." - Alan J. Perlis


[More on Clojure rationale](https://clojure.org/about/rationale)


# Links
* [Rich Hickey's Greatest Hits
  Videos](https://changelog.com/posts/rich-hickeys-greatest-hits) - Simple Made Easy being most iconic.
* [ClojureScript cheatsheet](https://cljs.info/cheatsheet/)
* [VSCode Calva](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva)
* [Awesome Clojure](https://github.com/razum2um/awesome-clojure) Curated list of
  libraries
* [HTML with Hiccup, Syntax](https://github.com/weavejester/hiccup/wiki/Syntax)
* [CSS with Garden](https://github.com/noprompt/garden#syntax)
* [Graal
  interop](http://gigasquidsoftware.com/blog/2017/10/22/embedded-interop-between-clojure-r-and-python-with-graalvm/)
  with R and Python
* [libpython-clj Interop](https://github.com/clj-python/libpython-clj), [PyPlot Tutorial](http://gigasquidsoftware.com/blog/2020/01/18/parens-for-pyplot/), [NLP with Python interop](http://gigasquidsoftware.com/blog/2020/01/24/clojure-interop-with-python-nlp-libraries/)
* [honeySQL](https://github.com/jkk/honeysql), [Korma SQL](https://github.com/korma/Korma) and [Toucan, ORM like](https://github.com/metabase/toucan)
