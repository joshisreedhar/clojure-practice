(ns tictactoe.game.board
  (:gen-class))

(defn isDiagnol? [cell]
  (= (:row cell) (:col cell)))

(defn getDiagnols [player-board]
  (filter isDiagnol? player-board))

(defn cell-count [player-board]
  (count (map :row player-board)))

(defn isBoardFilled? [gridsize player1-board player2-board]
  (=
    (* gridsize gridsize)
    (+ (cell-count player1-board) (cell-count player2-board))))

(defn add-player-move [player-move player-board]
  (cons player-move player-board))

(defn isComplete? [gridsize evalfn player-board]
  (= gridsize (count (map evalfn player-board))))

(defn isRowComplete? [gridsize player-board]
  (isComplete? gridsize :row player-board))

(defn isColComplete? [gridsize player-board]
  (isComplete? gridsize :col player-board))

(defn isDiagnolComplete? [gridsize player-board]
  (isComplete? gridsize :row (getDiagnols player-board)))

(defn isWinner? [gridsize player-board]
  (or
    (isRowComplete? gridsize player-board)
    (isColComplete? gridsize player-board)
    (isDiagnolComplete? gridsize player-board)
    false))