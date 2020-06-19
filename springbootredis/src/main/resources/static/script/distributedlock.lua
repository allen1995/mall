---
--- create by allen
---

--- 获取key
local key = KEYS[1]

--- 获取value
local value = KEYS[2]

--- 获取一个参数
local expire = ARGV[1]

if redis.call("get", key) == false then
    if redis.call("set", key, value) then
        if tonumber(expire) > 0 then
            redis.call("expire",key,expire)
        end
        return true
    end
    return false
else
    return false
end
