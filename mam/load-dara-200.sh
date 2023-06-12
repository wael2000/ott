arr[0]="Mecca"
arr[1]="Cairo"
arr[2]="London"
arr[3]="Paris"
arr[4]="Amsterdam"
arr[5]="Munich"
arr[6]="Algeria"
arr[7]="Oman"
arr[8]="Yemen"
arr[9]="Doha"
arr[10]="Qatar"

users[0]="wael"
users[1]="ahmed"
users[2]="doaa"
users[3]="mohamed"

years[0]=2009
years[1]=2020
years[2]=2012
years[3]=1998
years[4]=2002
years[5]=2003
years[6]=2022

types[0]="Movie"
types[1]="Series"
types[2]="Documentary"

ageRatings[0]="Kids"
ageRatings[0]="Adults"

tags[0]=1
tags[1]=2
tags[2]=3
tags[3]=4
tags[4]=5
tags[5]=6



for i in {1..200} ; do

rand=$[$RANDOM % ${#arr[@]}]
user=$[$RANDOM % ${#users[@]}]
year=$[$RANDOM % ${#years[@]}]
type=$[$RANDOM % ${#types[@]}]
ageRating=$[$RANDOM % ${#ageRatings[@]}]
tag1=$[$RANDOM % ${#tags[@]}]
tag2=$[$RANDOM % ${#tags[@]}]

TEMP_FILE="media.json"

cat > "${TEMP_FILE}" << EOF
{
    "name": "Journey to ${arr[$rand]} $i",
    "title": "Journey to ${arr[$rand]} $i",
    "description": "Journey to ${arr[$rand]} $i",
    "longDescription": "Journey to ${arr[$rand]} $i",
    "hour": 1,
    "minute": 30,
    "releaseYear" : ${years[$year]},
    "type": "${types[$type]}",
    "ageRating": "${ageRatings[$ageRating]}",
    "posterHorizontal":"poster-h-$i.png",
    "posterVertical":"poster-v-$i.png",
    "heroArt":"hero-art-$i.png",
    "banner":"banner-$i.png",

    "createdBy": "${users[$user]}",  
    "thumbnailMobile": "mobile1.png",
    "thumbnailTv": "tv1.png",
    "thumbnailWeb": "web1.png",
    
    "tags": [
        {"id": ${tags[$tag1]}},
        {"id": ${tags[$tag2]}}
    ],
    "metadata" : [
        {
          "name" : "Director",
          "value" : "Ali$i"
        },
        {
          "name" : "Writer",
          "value" : "Waleed$i"
        },
        {
          "name" : "Actor",
          "value" : "Wael$i"
        }
    ]
}
EOF

curl http://127.0.0.1:8080/media \
  --request POST \
  --header "Content-Type: application/json" \
  --data "@${TEMP_FILE}"

rm "${TEMP_FILE}"

done 