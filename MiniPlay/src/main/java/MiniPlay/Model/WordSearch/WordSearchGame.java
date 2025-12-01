package MiniPlay.Model.WordSearch;

import MiniPlay.Utilities.Tools;

import java.util.*;

public class WordSearchGame {

    public final int ROWS = 10;
    public final int COLS = 10;

    private char[][] grid = new char[ROWS][COLS];

    // 10 animal-themed words, all 4+ letters
    private List<String> words = Tools.getWords(10);

    // Track found words
    private Set<String> foundWords = new HashSet<>();

    // Track selected cells in order
    private List<int[]> selectedCells = new ArrayList<>();

    private Random rand = new Random();

    public WordSearchGame() {
        //List<String> t = Tools.getWords(2);
        //System.out.println(t);
        // Initialize grid with blanks
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                grid[r][c] = ' ';

        placeAllWords();
        fillRandomLetters();
    }

    public List<String> getWords() {
        return words;
    }

    public boolean isWordFound(String w) {
        return foundWords.contains(w);
    }

    public char getLetter(int r, int c) {
        return grid[r][c];
    }

    public Set<String> getFoundWords() {
        return foundWords;
    }

    public void toggleSelect(int r, int c) {
        for (int i = 0; i < selectedCells.size(); i++) {
            int[] cell = selectedCells.get(i);
            if (cell[0] == r && cell[1] == c) {
                selectedCells.remove(i);
                return;
            }
        }
        selectedCells.add(new int[]{r, c});
    }

    // Called after every click to see if the user formed a word
    public String checkForCompletedWord() {
        if (selectedCells.isEmpty())
            return null;

        StringBuilder sb = new StringBuilder();
        for (int[] cell : selectedCells)
            sb.append(grid[cell[0]][cell[1]]);

        String attempt = sb.toString();

        for (String w : words) {
            if (attempt.equals(w) && !foundWords.contains(w)) {
                foundWords.add(w);
                selectedCells.clear();
                return w;
            }
        }
        return null;
    }

    public void clearSelected() {
        selectedCells.clear();
    }

    private void placeAllWords() {
        for (String w : words)
            placeWord(w);
    }

    private void placeWord(String word) {
        boolean placed = false;
        int attempts = 0;

        while (!placed && attempts < 400) {
            attempts++;

            int direction = rand.nextInt(2);  // 0 = horizontal, 1 = vertical
            int row = rand.nextInt(ROWS);
            int col = rand.nextInt(COLS);

            if (direction == 0) { // HORIZONTAL
                if (col + word.length() <= COLS) {

                    // Prevent stacking directly above or below
                    boolean blocked = false;
                    if (row > 0) {
                        for (int i = 0; i < word.length(); i++)
                            if (grid[row - 1][col + i] != ' ')
                                blocked = true;
                    }
                    if (row < ROWS - 1) {
                        for (int i = 0; i < word.length(); i++)
                            if (grid[row + 1][col + i] != ' ')
                                blocked = true;
                    }

                    if (!blocked && fitsHoriz(word, row, col)) {
                        for (int i = 0; i < word.length(); i++)
                            grid[row][col + i] = word.charAt(i);
                        placed = true;
                    }
                }

            } else { // VERTICAL
                if (row + word.length() <= ROWS) {

                    boolean blocked = false;
                    for (int i = 0; i < word.length(); i++)
                        if (grid[row + i][col] != ' ')
                            blocked = true;

                    if (!blocked && fitsVert(word, row, col)) {
                        for (int i = 0; i < word.length(); i++)
                            grid[row + i][col] = word.charAt(i);
                        placed = true;
                    }
                }
            }
        }
    }

    private boolean fitsHoriz(String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            char existing = grid[row][col + i];
            if (existing != ' ' && existing != word.charAt(i))
                return false;
        }
        return true;
    }

    private boolean fitsVert(String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            char existing = grid[row + i][col];
            if (existing != ' ' && existing != word.charAt(i))
                return false;
        }
        return true;
    }

    private void fillRandomLetters() {
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                if (grid[r][c] == ' ')
                    grid[r][c] = (char) ('A' + rand.nextInt(26));
    }
}