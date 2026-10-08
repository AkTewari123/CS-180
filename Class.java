int f() {
    try {
        return 1;
    } finally {
        IO.println("finally ran anyway");
    }
}

void main() {
    IO.println(f());
}