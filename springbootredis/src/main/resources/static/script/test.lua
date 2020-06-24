-- 获取锁名称
local lockName = KEYS[1]

-- 获取锁的值
local value = ARGV[1]

-- 获取锁
local requestId = ARGV[2]

if redis.call("get", requestId) then
    redis.call("setnx",lockName,value)
    redis.call("set",requestId,1)
    redis.call("expire",lockName,120)
    redis.call("expire",lockName,120)
else
    redis.call("incr",requestId)
end


-- 获取锁名称
local lockName = KEYS[1]

-- 获取锁的值
local value = ARGV[1]

-- 获取锁
local requestId = ARGV[2]

if  tonumber(redis.call("get",requestId)) > 1 then
    redis.call("decr", requestId)
elseif tonumber(redis.call("get",requestId)) == 1 then
    if redis.call("get", lockName) == value then
       redis.call("del", lockName)
       redis.call("del", requestId)
    end
end


