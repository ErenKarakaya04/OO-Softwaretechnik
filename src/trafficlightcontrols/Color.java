package trafficlightcontrols;

    public enum Color {
        Red {
            public Color next() { return RedAmber; }
        },
        RedAmber {
            public Color next() { return Green; }
        },
        Green {
            public Color next() { return Amber; }
        },
        Amber {
            public Color next() { return Red; }
        };

        public abstract Color next();
    }
