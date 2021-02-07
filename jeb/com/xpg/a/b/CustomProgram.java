package com.xpg.a.b;

import java.util.List;

public class CustomProgram {
    public class a {
        final CustomProgram a;
        private int b;
        private int c;
        private int d;

        public int a() {
            return this.b;
        }

        public void a(int arg1) {
            this.b = arg1;
        }

        public int b() {
            return this.c;
        }

        public void b(int arg1) {
            this.c = arg1;
        }

        public int c() {
            return this.d;
        }

        public void c(int arg1) {
            this.d = arg1;
        }

        @Override
        public String toString() {
            return this.b + "|" + this.c + "|" + this.d;
        }
    }

    public class b {
        final CustomProgram a;
        private int b;
        private int c;
        private int d;

        public int a() {
            return this.b;
        }

        public void a(int arg1) {
            this.b = arg1;
        }

        public int b() {
            return this.c;
        }

        public void b(int arg1) {
            this.c = arg1;
        }

        public int c() {
            return this.d;
        }

        public void c(int arg1) {
            this.d = arg1;
        }

        @Override
        public String toString() {
            return this.b + "|" + this.c + "|" + this.d;
        }
    }

    private int a;
    private List b;
    private List c;
    private int d;
    private int e;
    private int f;

    public int getUnit() {
        return this.f;
    }

    public void a(int arg1) {
        this.f = arg1;
    }

    public void a(List arg1) {
        this.b = arg1;
    }

    public int getTimeSegmentNumber() {
        return this.d;
    }

    public void b(int arg1) {
        this.d = arg1;
    }

    public void b(List arg1) {
        this.c = arg1;
    }

    public int getDistanceSegmentNumber() {
        return this.e;
    }

    public void c(int arg1) {
        this.e = arg1;
    }

    public int getUserId() {
        return this.a;
    }

    public void d(int arg1) {
        this.a = arg1;
    }

    public List setCustom1() {
        return this.b;
    }

    public List setCustom2() {
        return this.c;
    }

    @Override
    public String toString() {
        return "CustomProgram{userSlot=" + this.a + ", timeCustoms=" + this.b + ", distanceCustom=" + this.c + ", timeSegNumber=" + this.d + ", distanceSegNumber=" + this.e + ", unit=" + this.f + '}';
    }
}
