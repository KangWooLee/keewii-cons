(ns keewii-cons.core-test
(:use [incanter.charts]
      [incanter.core]))

(def cars (to-matrix (get-dataset :cars)))
(def y (sel cars :cols 0))
(def x (sel cars :cols 1))
(def plot1 (scatter-plot x y :legend true))
(view plot1)
;; plot the cosine function
(def x (range -1 5 0.01))
(def y (cos (mult 2 Math/PI x)))
(view (scatter-plot x y))
;; plot gamma pdf with different parameters
(def x2 (range 0 20 0.1))
(def gamma-plot (xy-plot x2 (pdf-gamma x2 :shape 1 :rate 2)
:legend true
:title "Gamma PDF"
:y-label "Density"))
(view gamma-plot)
(add-lines gamma-plot x2 (pdf-gamma x2 :shape 2 :rate 2))
(add-lines gamma-plot x2 (pdf-gamma x2 :shape 3 :rate 2))
(add-lines gamma-plot x2 (pdf-gamma x2 :shape 5 :rate 1))
(add-lines gamma-plot x2 (pdf-gamma x2 :shape 9 :rate 0.5))

;; use :group-by option
(use '(incanter core charts datasets))

(with-data (get-dataset :chick-weight)
(view (xy-plot :Time :weight :group-by :Chick)))