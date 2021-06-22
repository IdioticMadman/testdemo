package com.robert;

public class Main {

    public static class Node {
        public Integer data;
        public Node next;

        public Node(Integer data) {
            this.data = data;
        }

        public Node append(Node node) {
            this.next = node;
            return node;
        }
    }

    public static void main(String[] args) {
        Node header = new Node(1);
        header.append(new Node(2))
                .append(new Node(3))
                .append(new Node(4))
                .append(new Node(5))
                .append(new Node(6))
                .append(new Node(7))
                .append(new Node(8))
                .append(new Node(9));
//        Node cur = header;
//        while (cur != null) {
//            System.out.println(cur.data);
//            cur = cur.next;
//        }
        Node result = reverse2(header);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    public static Node reverse1(Node header) {
        Node tmp = new Node(-1);
        Node cur = header;
        while (cur != null) {
            Node next = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            cur = next;
        }
        return tmp.next;
    }

    public static Node reverse2(Node header) {
        Node dummy = new Node(-1);
        dummy.next = header;
        Node prev = dummy.next;
        Node pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy.next;
    }
}
