---
--- create by allen
---

--- 获取锁名称
local localName = KEYS[1]

--- 获取value
local value = ARGV[1]

--- 获取requestId
local requestId = ARGV[2]

if redis.call("get", requestId) == false then
    if redis.call("setnx", localName, value) == 1 and
            redis.call("set", requestId, 1) then
        --redis.call("expire",localName,60)
        --redis.call("expire",requestId,60)
        return true
    else
        return false
    end
else
    redis.call("incr", requestId )
    return true
end

--if redis.call("get", key) == false then
--    if redis.call("set", key, value) then
--        if tonumber(expire) > 0 then
--            redis.call("expire",key,expire)
--        end
--        return true
--    end
--    return false
--else
--    return false
--end
