#!/bin/sh

docker run --name pg_notify \
    -p 5432:5432 \
    -e POSTGRES_DB=notifications \
    -e POSTGRES_PASSWORD=notifications \
    -d postgres