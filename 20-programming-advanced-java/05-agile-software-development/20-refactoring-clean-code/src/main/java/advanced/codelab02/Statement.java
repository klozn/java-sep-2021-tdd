package advanced.codelab02;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    private final List<String> statementLines;
    private String headerLines;
    private String footerLines;

    public Statement() {
        statementLines = new ArrayList<>();
    }

    protected void addStatementLine(String statementLine) {
        statementLines.add(statementLine);
    }

    protected void setHeaderLines(String headerLines) {
        this.headerLines = headerLines;
    }

    protected void setFooterLines(String footerLines) {
        this.footerLines = footerLines;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(headerLines);
        statementLines.forEach(sb::append);
        sb.append(footerLines);
        return sb.toString();
    }
}
