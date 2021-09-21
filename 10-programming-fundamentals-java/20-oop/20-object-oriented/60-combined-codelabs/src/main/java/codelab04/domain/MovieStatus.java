package codelab04.domain;

public enum MovieStatus {
    ONE_DAY_MOVIE, TRENDING_MOVIE, OLDER_MOVIE;

    public MovieStatus downGrade() {
        if (this.equals(ONE_DAY_MOVIE)) {
            return TRENDING_MOVIE;
        }
        return OLDER_MOVIE;
    }
}
