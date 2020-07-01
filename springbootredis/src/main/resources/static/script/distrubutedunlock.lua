---
--- create by allen
---

--- 获取锁名称
local localName = KEYS[1]

--- 获取value
local value = ARGV[1]

--- 获取requestId
local requestId = ARGV[2]

if tonumber(redis.call("get",requestId)) > 1 then
    redis.call("decr", requestId)
    return true
elseif redis.call("get",localName) == value then
    if redis.call("del", localName) and redis.call("del", requestId) then
        return true
    else
        return false
    end
else
    return false
end