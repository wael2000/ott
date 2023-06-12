TEMP_FILE="media.json"

cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to Mecca",
    "hour": 1,
    "minute": 30,
    "name": "Journey to Mecca",
    "thumbnailMobile": "mobile1.png",
    "thumbnailTv": "tv1.png",
    "thumbnailWeb": "web1.png",
    "type": "Movie",
    "tags": [
        {"id": 1},
        {"id" : 2},
        {"id" : 6}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Ali"
        },
        {
          "name" : "Writer",
          "value" : "Waleed"
        },
        {
          "name" : "Actor",
          "value" : "Wael"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"


cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael", 
    "description": "Journey to Medina",
    "hour": 1,
    "minute": 45,
    "name": "Journey to Medina",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1},
        {"id" : 2}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Ali"
        },
        {
          "name" : "Writer",
          "value" : "Waleed"
        },
        {
          "name" : "Actor",
          "value" : "Wael"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"



cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to Cairo",
    "hour": 1,
    "minute": 45,
    "name": "Journey to Cairo",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Ahmed Salim"
        },
        {
          "name" : "Writer",
          "value" : "Doaa Ahmed"
        },
        {
          "name" : "Actor",
          "value" : "Moahmed Samy"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"


cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to Dubai",
    "hour": 1,
    "minute": 5,
    "name": "Journey to Dubai",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Ali"
        },
        {
          "name" : "Writer",
          "value" : "Waleed"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"

cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "admin",
    "description": "Journey to Doha",
    "hour": 2,
    "minute": 11,
    "name": "Journey to Doha",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 2}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Osama"
        },
        {
          "name" : "Writer",
          "value" : "Jalal"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"


cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "admin",
    "description": "Journey to Algeria",
    "hour": 1,
    "minute": 56,
    "name": "Journey to Algeria",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"


cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to Khartoum",
    "hour": 1,
    "minute": 33,
    "name": "Journey to Khartoum",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"

cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to Baghdad",
    "hour": 1,
    "minute": 56,
    "name": "Journey to Baghdad",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"


cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to London",
    "hour": 1,
    "minute": 56,
    "name": "Journey to London",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"


cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to Paris",
    "hour": 1,
    "minute": 56,
    "name": "Journey to Paris",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"


cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "admin",
    "description": "Journey to Amsterdam",
    "hour": 1,
    "minute": 56,
    "name": "Journey to Amsterdam",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"

cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "admin",
    "description": "Journey to Madrid",
    "hour": 1,
    "minute": 56,
    "name": "Journey to Madrid",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"

cat > "${TEMP_FILE}" << EOF
{
    "createdBy": "wael",
    "description": "Journey to Barcelons",
    "createdBy": "wael",
    "hour": 1,
    "minute": 56,
    "name": "Journey to Barcelons",
    "thumbnailMobile": "mobile2.png",
    "thumbnailTv": "tv2.png",
    "thumbnailWeb": "web2.png",
    "type": "Movie",
    "tags": [
        {"id": 1}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Mohsen"
        },
        {
          "name" : "Writer",
          "value" : "Samy"
        },
        {
          "name" : "Camera Man",
          "value" : "Fady"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"
