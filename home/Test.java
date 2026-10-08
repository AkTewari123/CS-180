void main() {
    VideoGame zelda = new PCGame("Zelda", 4.00, 3.2, 4.0);
    VideoGame olderzelda = new PCGame("Zelda", 4.0, 3.21, 4.0);

    if (zelda.equals(olderzelda)) {
        IO.println("true");
    } else {
        IO.println("false");

    }
}
