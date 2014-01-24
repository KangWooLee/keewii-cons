(ns keewii_cons.sequence
  (:use [keewii_cons.toolbox :only (vowel)]
        [overtone.live :only (osc-handle)]
        [overtone.live :only (stop)]))

;consonant sequences
(defn M [vowel] 
  [{:t 0 :fa 240.0 :fb 1000.0 :fc 2600.0 :vol 0.5}
   {:t 100 :fa 240.0 :fb 1000.0 :fc 2600.0 :vol 0.5}
   {:t 120  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}])
(defn W [vowel] 
  [{:t 0 :fa 300 :fb 680 :fc 2480 :vol 1};start of u
   {:t 40 :fa 300 :fb 680 :fc 2480 :vol 1};keep u
   {:t 140  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}])
(defn Y [vowel] 
  [{:t 0 :fa 280 :fb 2250 :fc 2890 :vol 1};start of i
   {:t 40 :fa 280 :fb 2250 :fc 2890 :vol 1};keep i
   {:t 100  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}])
(defn B [vowel] 
  [{:t 0 :fa 500 :fb 720 :fc 2400 :vol 2} ;f2 = 950 or 720
   {:t 40  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}
   {:t 80  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}])
(defn L [vowel] 
  [{:t 0 :fa 590 :fb 880 :fc 2500 :vol 1};eo sound
   {:t 60 :fa 590 :fb 880 :fc 2500 :vol 1.5};u
   {:t 80  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}])
(defn D [vowel] 
  [{:t 0 :fa 500 :fb 2000 :fc 2700 :vol 2} ;f2 = 1800, or 350,1200,2600
   {:t 30  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol 2}
   {:t 80  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}])
(defn G [vowel] 
  [{:t 0 :fa 300 :fb 3500 :fc 1500 :vol 2} ; 0,3500
   ;{:t 60 :fa 290 :fb 680 :fc 2700 :vol 2} ;   
   {:t 30  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol 2}
   {:t 45  :fa (vowel :fa) :fb (vowel :fb)  :fc (vowel :fc) :vol (vowel :vol)}])

 (defn str2con_conv [Char]
   (case Char
     "m" M
     "w" W
     "y" Y))