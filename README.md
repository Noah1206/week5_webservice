배포 URL과 실제 요청·응답 결과를 README에 기록

배포 URL : https://week5-webservice.onrender.com/

Create : POST https://week5-webservice.onrender.com/api/products
결과 : {
"id": 2,
"name": "m6맥북프로",
"description": "애플사 최고성능 맥북",
"category": "노트북",
"date": 2026,
"price": 30000000
}

findById: GET https://week5-webservice.onrender.com/api/products/1
결과 : {
"id": 1,
"name": "맥북air",
"description": "무겁지만 성능이 좋은 노트북입니다",
"category": "노트북",
"date": 2024,
"price": 2000000
}

findAll : GET https://week5-webservice.onrender.com/api/products
결과 : [
{
"id": 1,
"name": "맥북air",
"description": "무겁지만 성능이 좋은 노트북입니다",
"category": "노트북",
"date": 2024,
"price": 2000000
},
{
"id": 2,
"name": "m6맥북프로",
"description": "애플사 최고성능 맥북",
"category": "노트북",
"date": 2026,
"price": 30000000
}
]

update : PUT https://week5-webservice.onrender.com/api/products/1
결과 : {
"id": null,
"name": "max맥북프로",
"description": "애플사의 최신형 최공성능 노트북입니다.",
"category": "노트북",
"date": 2026,
"price": 30000000
}

delete : DELETE https://week5-webservice.onrender.com/api/products/3
결과 : 없음

checkCreate : POST https://week5-webservice.onrender.com/api/products
결과 : {
"id": 2,
"name": "아이폰프로",
"description": "애플사의 최신형 아이폰",
"category": "아이폰",
"date": 2022,
"price": 100000
}

findCategoryProduct : GET https://week5-webservice.onrender.com/api/products/category/노트북
결과 : 