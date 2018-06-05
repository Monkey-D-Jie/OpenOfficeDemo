package com.jf.myDemo.converfileter;

import com.sun.star.datatransfer.XTransferable;
import com.sun.star.datatransfer.XTransferableSupplier;
import com.sun.star.frame.XController;
import com.sun.star.lang.XComponent;
import com.sun.star.text.*;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.view.XSelectionSupplier;
import org.jodconverter.filter.Filter;
import org.jodconverter.filter.FilterChain;
import org.jodconverter.office.OfficeContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wjie
 * @date: 2018/2/28 0028
 * @time: 15:39
 * To change this template use File | Settings | File and Templates.
 */

public class MyPageFilter implements Filter {

    private final int page;

    /**
     * Creates a new filter that will select the specified page while converting a document (only the
     * given page will be converted).
     *
     * @param page The page number to convert.
     */
    public MyPageFilter(final int page) {
        super();
        this.page = page;
    }

    @Override
    public void doFilter(OfficeContext context, XComponent document, FilterChain chain) throws Exception {
        // Querying for the interface XTextDocument (text interface) on the XComponent.
        final XTextDocument docText = UnoRuntime.queryInterface(XTextDocument.class, document);

        // We need both the text cursor and the view cursor in order
        // to select the whole content of the desired page.
        final XController controller = docText.getCurrentController();
        final XTextCursor textCursor = docText.getText().createTextCursor();
        final XTextViewCursor viewCursor =
                UnoRuntime.queryInterface(XTextViewCursorSupplier.class, controller).getViewCursor();

        // Reset both cursors to the beginning of the document
        textCursor.gotoStart(false);
        viewCursor.gotoStart(false);
        // Querying for the interface XPageCursor on the view cursor.
        final XPageCursor pageCursor = UnoRuntime.queryInterface(XPageCursor.class, viewCursor);

        // Jump to the page to select (first page is 1) and move the
        // text cursor to the beginning of this page.
        pageCursor.jumpToPage((short) page);
        textCursor.gotoRange(viewCursor.getStart(), false);

        // Jump to the end of the page and expand the text cursor
        // to the end of this page.
        pageCursor.jumpToEndOfPage();
        textCursor.gotoRange(viewCursor.getStart(), true);

        // Select the whole page.
        final XSelectionSupplier selectionSupplier =
                UnoRuntime.queryInterface(XSelectionSupplier.class, controller);
        selectionSupplier.select(textCursor);

        // Copy the selection (whole page).
        final XTransferableSupplier transferableSupplier =
                UnoRuntime.queryInterface(XTransferableSupplier.class, controller);
        final XTransferable xTransferable = transferableSupplier.getTransferable();

        // Now select the whole document.
        textCursor.gotoStart(false); // Go to the start
        textCursor.gotoEnd(true); // Go to the end, expanding the cursor's text range
        selectionSupplier.select(textCursor);

        // Paste the previously copied page. This will replace the
        // current selection (the whole document).
        transferableSupplier.insertTransferable(xTransferable);

        // Invoke the next filter in the chain
        chain.doFilter(context, document);
    }
}
