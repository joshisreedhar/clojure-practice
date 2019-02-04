(ns tictactoe.core
  (:require [tictactoe.game.board :as board])
  (:gen-class))

(def move (atom {:row 0 :col 0}))

(def player1-board (atom #{}))
;(def player2-board (tictactoe.game.board/new))

(def should-continue (atom true))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (while (= @should-continue true)
    (do
      (println "row:")
      (swap! move assoc  :row (read-line))
      (println "col:")
      (swap! move assoc  :col (read-line))
      (println (deref move))
      (swap! player1-board conj (deref move))
      (println (deref player1-board))
      (reset! should-continue (not (board/isWinner? 3 (deref player1-board)))))))


