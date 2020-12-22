FROM alpine

RUN apk add --no-cache python3
RUN apk update
RUN apk add py-pip

ENV APP_DIR /app
RUN mkdir ${APP_DIR}
VOLUME ${APP_DIR}
WORKDIR ${APP_DIR}
COPY requirements.txt .
RUN pip3 install --upgrade pip && \
    pip3 install -r requirements.txt

EXPOSE 80
COPY src .
ENTRYPOINT ["python3", "app.py"]