package org.pb.stack.util;

public class LinkList<T> {
    private Link<T> first;

    public LinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     *
     *<p>
     *description:????????????????????
     *</p>
     *@param obj
     * @author ex_pengbo
     * @see
     */
    public void insertFirst(T obj) {
        Link<T> nextLink = new Link<T>(obj);
        nextLink.setNext(first);
        first = nextLink;
    }

    /**
     *
     *<p>
     *description:??????????????
     *</p>
     *@return
     * @author ex_pengbo
     * @see
     */
    public T deleteFirst() {
        Link<T> temp = null;
        if (isEmpty())
            return null;
        temp = first;
        first = first.getNext();
        return (T)temp.getObj();
    }

    /**
     *
     *<p>
     *description:???????¦Â???????????
     *</p>
     *@param obj
     * @author ex_pengbo
     * @see
     */
    @SuppressWarnings("unused")
    private void insertAfter(T obj) {
        if (first == null) {
            first = new Link<T>(obj);
            return;
        }
        Link<T> endLink = first;
        while (endLink != null) {
            if (endLink.getNext() == null) {
                break;
            }
            endLink = endLink.getNext();
        }
        endLink.setNext(new Link<T>(obj));
    }

    /**
     *
     *<p>
     *description:????????????????
     *</p>
     *@param keyWord
     * @author ex_pengbo
     * @see
     */
    @SuppressWarnings("unused")
    private void deletByKeyWord(Object keyWord) {
        Link<T> current = first;
        while (current != null) {
            String infoStr = current.getObj().toString();
            if (infoStr.indexOf(keyWord.toString()) != -1) {
                Link<T> previous = getPreviousLink(current);
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
            }
            current = current.getNext();
        }
    }

    /**
     *
     *<p>
     *description:?????????????????????
     *</p>
     *@param current
     *@return
     * @author ex_pengbo
     * @see
     */
    private Link<T> getPreviousLink(Link<T> current) {
        Link<T> previous = first;
        if (first == current) {
            return null;
        }
        while (previous != null) {
            if (previous.getNext() == current) {
                break;
            }
            previous = previous.getNext();
        }
        return previous;
    }

    /**
     *
     *<p>
     *description:??????????
     *</p>
     * @author ex_pengbo
     * @see
     */
    public void displayList() {
        Link<T> current = first;
        while (current != null) {
            System.out.println(current.getObj());
            current = current.getNext();
        }
    }
}
