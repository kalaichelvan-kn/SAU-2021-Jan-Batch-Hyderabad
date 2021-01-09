-- 2
select count(id) TotalRoutes, sum(distance) TotalDistance, airlineid 
from `travel-sample` where type="route" group by airlineid;

-- 3
-- inner join
SELECT * FROM `travel-sample` lefttab JOIN `travel-sample` righttab ON lefttab.airlineid = META(righttab).id
WHERE lefttab.sourceairport = "SFO";
-- left join
SELECT * FROM `travel-sample` lefttab LEFT JOIN `travel-sample` righttab ON lefttab.airlineid = META(righttab).id
WHERE lefttab.sourceairport = "SFO";
-- right join
SELECT * FROM `travel-sample` lefttab RIGHT JOIN `travel-sample` righttab ON lefttab.airlineid = META(righttab).id
WHERE lefttab.sourceairport = "SFO";

-- 4
-- map
    function (doc, meta) {
    if(doc.type=="route")
        emit(meta.id, null);
    }

-- export
.\cbexport json -c couchbase://127.0.0.1 -u Administrator -p 19343912 -b travel-sample -o F:/travelSample.json -f lines -t 4

--import
.\cbimport json -c couchbase://127.0.0.1 -u Administrator -p 19343912 -b AccoTravelBucket -f lines -d file://F:/travelSample.json -t 4 -g %id%