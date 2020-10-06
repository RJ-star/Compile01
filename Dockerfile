FROM openjdk:13
WORKDIR /app/
COPY ./* ./
RUN javac Compile.java