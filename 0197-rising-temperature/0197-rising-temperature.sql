# Write your MySQL query statement below
select weather_1.id from Weather as weather_1, Weather as weather_2
where datediff(weather_1.RecordDate, weather_2.RecordDate) = 1 and weather_1.Temperature > weather_2.Temperature


