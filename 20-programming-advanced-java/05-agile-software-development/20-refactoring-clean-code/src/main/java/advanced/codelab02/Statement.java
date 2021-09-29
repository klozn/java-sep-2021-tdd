package advanced.codelab02;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    private final List<String> statementLines;
    private String header;
    private String footer;

    public Statement() {
        statementLines = new ArrayList<>();
    }

    protected void addStatementLine(String statementLine) {
        statementLines.add(statementLine);
    }

    protected void setHeader(String header) {
        this.header = header;
    }

    protected void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(header);
        statementLines.forEach(sb::append);
        sb.append(footer);
        return sb.toString();
    }
}
